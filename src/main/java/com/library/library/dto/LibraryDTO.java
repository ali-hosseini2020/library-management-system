package com.library.library.dto;
import lombok.*;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class LibraryDTO {
    private Long id;
    private String name;
    private String address;
    private String contactInfo;
    private List<LibraryBranchDTO> branches;
    private List<LibraryUserDTO> users;
    private List<LibraryEventDTO> events;
}
