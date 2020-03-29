package com.ere.consumer.domain.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;

/**
 * info document
 *
 * @author ilya
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("docs")
@EqualsAndHashCode(callSuper = false)
public class InfoDocument implements Serializable {

    @MongoId
    @JsonProperty("id")
    private String id;

    @JsonProperty("uid")
    private String uid;

    @JsonProperty("info")
    private String info;

    @JsonProperty("owner")
    private Owner owner;

}
