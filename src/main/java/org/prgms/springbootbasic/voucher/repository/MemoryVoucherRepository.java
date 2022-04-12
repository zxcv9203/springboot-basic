package org.prgms.springbootbasic.voucher.repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.prgms.springbootbasic.voucher.vo.Voucher;
import org.springframework.stereotype.Repository;

import com.google.common.base.Preconditions;

@Repository
public class MemoryVoucherRepository implements VoucherRepository {
	private final Map<UUID, Voucher> memory = new ConcurrentHashMap<>();

	/**
	 * Voucher를 memory에 저장하는 메서드
	 *
	 * @param voucher
	 * @return 저장된 Voucher
	 */
	@Override
	public UUID save(Voucher voucher) {
		Preconditions.checkArgument(voucher != null, "voucher은 null이면 안됩니다!");

		memory.put(voucher.getVoucherId(), voucher);
		return voucher.getVoucherId();
	}

	/**
	 * 저장된 Voucher들을 Voucher의 종류에 따라 조회하는 메서드
	 *
	 * @return Map<String, List < Voucher>>
	 */
	@Override
	public Map<String, List<Voucher>> getVoucherListByType() {
		return memory.entrySet().stream()
			.map(e -> e.getValue())
			.collect(Collectors.groupingBy(Voucher::getVoucherType));
	}

	@Override
	public int getTotalVoucherCount() {
		return memory.size();
	}

	@Override
	public Voucher findById(UUID voucherId) {
		return memory.entrySet().stream()
			.filter(e -> e.getKey().equals(voucherId))
			.map(e -> e.getValue())
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException());
	}

}
