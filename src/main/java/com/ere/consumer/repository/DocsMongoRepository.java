package com.ere.consumer.repository;

import com.ere.consumer.domain.domain.InfoDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Docs mongo repository
 *
 * @author ilya
 * @version 1.0
 */
public interface DocsMongoRepository extends MongoRepository<InfoDocument, String> {}
