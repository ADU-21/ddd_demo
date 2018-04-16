package com.adu21.ddd.quotation.repository;

import com.adu21.ddd.quotation.domain.model.CarPolicyQuotation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CarPolicyQuotationRepository extends CrudRepository<CarPolicyQuotation, Long> {
    Optional<CarPolicyQuotation> findByQuoteId(String quoteId);
}
