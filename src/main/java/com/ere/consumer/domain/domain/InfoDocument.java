package com.ere.consumer.domain.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
@EqualsAndHashCode(callSuper = false)
public class InfoDocument implements Serializable {

    @JsonProperty("id")
    private String id;

    @JsonProperty("info")
    private String info;

}
