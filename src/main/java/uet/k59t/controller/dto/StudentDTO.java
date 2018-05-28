package uet.k59t.controller.dto;

public class StudentDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String msv;
    private ConductScoreDTO conductScoreDTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMsv() {
        return msv;
    }

    public void setMsv(String msv) {
        this.msv = msv;
    }

    public ConductScoreDTO getConductScoreDTO() {
        return conductScoreDTO;
    }

    public void setConductScoreDTO(ConductScoreDTO conductScoreDTO) {
        this.conductScoreDTO = conductScoreDTO;
    }
}
