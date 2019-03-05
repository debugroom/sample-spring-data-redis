package org.debugroom.sample.spring.data.redis.app.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SessionScope
@Component
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class SampleModel implements Serializable {

    private String lastUpdatedHost;
    private Date lastUpdatedAt;


}
