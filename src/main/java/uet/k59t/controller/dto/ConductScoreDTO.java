package uet.k59t.controller.dto;

public class ConductScoreDTO {

    private int yThucHocTap;

    private int yThucChapHanh;

    private int yThucHoatDong;

    private int phamChatCongDan;

    private int congTacPhuTrach;

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
}
