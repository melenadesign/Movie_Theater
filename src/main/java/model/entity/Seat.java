package model.entity;

public class Seat {
    private int seatId;
    private int rowNumber;
    private int seatNumber;

    public Seat(int seatId, int rowNumber, int seatNumber) {
        this.seatId = seatId;
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
    }
    //todo builder may be

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }


}
