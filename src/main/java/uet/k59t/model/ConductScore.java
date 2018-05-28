package uet.k59t.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class ConductScore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @Size(max = 30, min = 0)
//    @Column(name = "y_thuc_hoc_tap")
    private int yThucHocTap;

//    @Size(max = 25, min = 0)
//    @Column(name = "y_thuc_chap_hanh")
    private int yThucChapHanh;

//    @Size(max = 20, min = 0)
//    @Column(name = "y_thuc_hoat_dong")
    private int yThucHoatDong;

//    @Size(max = 15, min = 0)
//    @Column(name = "pham_chat_cong_dan")
    private int phamChatCongDan;

//    @Size(max = 10, min = 0)
//    @Column(name = "cong_tac_phu_trach")
    private int congTacPhuTrach;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getyThucHocTap() {
        return yThucHocTap;
    }

    public void setyThucHocTap(int yThucHocTap) {
        this.yThucHocTap = yThucHocTap;
    }

    public int getyThucChapHanh() {
        return yThucChapHanh;
    }

    public void setyThucChapHanh(int yThucChapHanh) {
        this.yThucChapHanh = yThucChapHanh;
    }

    public int getyThucHoatDong() {
        return yThucHoatDong;
    }

    public void setyThucHoatDong(int yThucHoatDong) {
        this.yThucHoatDong = yThucHoatDong;
    }

    public int getPhamChatCongDan() {
        return phamChatCongDan;
    }

    public void setPhamChatCongDan(int phamChatCongDan) {
        this.phamChatCongDan = phamChatCongDan;
    }

    public int getCongTacPhuTrach() {
        return congTacPhuTrach;
    }

    public void setCongTacPhuTrach(int congTacPhuTrach) {
        this.congTacPhuTrach = congTacPhuTrach;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
