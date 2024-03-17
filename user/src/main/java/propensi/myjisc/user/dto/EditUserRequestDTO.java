package propensi.myjisc.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditUserRequestDTO {
    UUID id;

    @NotBlank(message = "Nama required")
    String firstname;

    @NotBlank(message = "Email required")
    String email;

    @NotBlank(message = "Password required")
    String password;

    @NotBlank(message = "Role required")
    String role;
}
