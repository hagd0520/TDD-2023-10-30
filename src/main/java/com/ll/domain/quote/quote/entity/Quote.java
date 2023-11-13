package com.ll.domain.quote.quote.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Quote {
    private final long id;
    private final String authorName;
    private final String content;
}
