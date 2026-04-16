package org.bahmni.module.eventoutbox.model;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class OutboxEvent {
    private Integer id;
    private String uuid;
    private String title;
    private Date timestamp;
    private String uri;
    private String content;
    private String category;
    private String tags;
}
