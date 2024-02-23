package com.plal.trainapp.model;

public class Receipt {

  private int ticketNo;
  private User user;
  private String from;
  private String to;
  private double fairPaid;

  public int getTicketNo() {
    return ticketNo;
  }

  public void setTicketNo(int ticketNo) {
    this.ticketNo = ticketNo;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public double getFairPaid() {
    return fairPaid;
  }

  public void setFairPaid(double fairPaid) {
    this.fairPaid = fairPaid;
  }

  @Override
  public String toString() {
    String text = """
        -------------------------------------------------
        |  Ticket No : %d                               |
        |  User Name : %s %s                            |
        |  Email     : %s                               |
        -------------------------------------------------
        |  Journey Details                              |
        |  ---------------                              |
        |  From : %s                                    |
        |  To   : %s                                    |
        |  Paid Fair : $ %d                             |
        -------------------------------------------------
        """;
    return String.format(text, ticketNo, user.getFirstName(), user.getLastName(), user.getEmail(), from, to, fairPaid);
  }
}
