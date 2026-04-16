package org.bahmni.module.eventoutbox;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

@Getter
public class EMREvent<T> extends ApplicationEvent implements ResolvableTypeProvider {

    private final transient T entity;
    private final String category;
    private final String title;
    private final String uri;
    private final String content;
    private final String tags;

    public EMREvent(T entity, String category, String title, String uri, String content, String tags) {
        super(entity);
        this.entity = entity;
        this.category = category;
        this.title = title;
        this.uri = uri;
        this.content = content;
        this.tags = tags;
    }

    public EMREvent(T entity, String category, String title, String uri, String content) {
        this(entity, category, title, uri, content, category);
    }

    @Override
    public ResolvableType getResolvableType() {
        return ResolvableType.forClassWithGenerics(getClass(), ResolvableType.forInstance(this.entity));
    }
}
