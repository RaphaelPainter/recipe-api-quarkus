package com.rpainter.model.misc;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;


public class Message {

    public String content;

    public Message(String contentForUser) {
        content = contentForUser;
    }
}