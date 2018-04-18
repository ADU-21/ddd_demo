package com.adu21.ddd.quotation.repository;

import com.adu21.ddd.quotation.domain.model.HomePolicyQuotation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HomePolicyQuotationRepository extends CrudRepository<HomePolicyQuotation, Long> {
    boolean existsByQuoteId(String QuoteId);
}
