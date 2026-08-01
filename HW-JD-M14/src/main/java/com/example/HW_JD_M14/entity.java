package com.example.HW_JD_M14;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class entity {
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter

    public static class Note {

        private long id;
        private String title;
        private String content;

        @Override
        public String toString() {
            return "Note{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", content='" + content + '\'' +
                    '}';
        }
    }
}
