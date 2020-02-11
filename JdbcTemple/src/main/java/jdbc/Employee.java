package jdbc;


import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Employee {

    private Integer id;
    private String lastName;
    private String email;

    private Integer deptId;
}
