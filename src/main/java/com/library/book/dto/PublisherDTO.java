package com.library.book.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class PublisherDTO {
    private Long id;
    private String name;
    private String address;
    private String contactInfo;
}