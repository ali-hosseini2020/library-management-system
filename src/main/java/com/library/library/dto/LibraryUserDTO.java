package com.library.library.dto;
import com.library.customizedenum.MembershipType;
import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class LibraryUserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private MembershipType membershipType;
    private Long libraryId;
    private Long branchId;
    private List<LibraryMembershipDTO> memberships;
}