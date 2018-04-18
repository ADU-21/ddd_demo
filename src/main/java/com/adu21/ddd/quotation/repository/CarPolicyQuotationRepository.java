package com.adu21.ddd.quotation.repository;

import com.adu21.ddd.quotation.domain.model.CarPolicyQuotation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CarPolicyQuotationRepository extends CrudRepository<CarPolicyQuotation, Long> {
    boolean existsByQuoteId(String quoteId);
}
