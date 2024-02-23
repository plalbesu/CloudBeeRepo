package com.plal.trainapp.model;

import java.util.ArrayList;
import java.util.List;

import com.plal.trainapp.constant.TrainSection;
import com.plal.trainapp.constant.TrainType;

public class Train {
  private String name;
  private int no;
  private TrainType type;
  private List<Section> sections;

  public Train(String name, int no) {
    this.name = name;
    this.no = no;
    this.type = TrainType.GENERAL;
    initSection();
  }

  public Train(String name, int no, TrainType type) {
    this.name = name;
    this.no = no;
    this.type = type;
    initSection();
  }

  private void initSection() {
    Section sectionA = new Section(TrainSection.SECTION_A);
    Section sectionB = new Section(TrainSection.SECTION_B, 0.1, 10);
    sections = new ArrayList<>();
    sections.add(sectionA);
    sections.add(sectionB);
  }

  public String getName() {
    return name;
  }

  public int getNo() {
    return no;
  }

  public void setType(TrainType type) {
    this.type = type;
  }

  private Section getSection(String secName) {
    return sections.stream().filter(sec -> sec.getSectionName().equals(secName)).findFirst().get();
  }
  public int blockAvailableSeat(String sectionName) {
    return getSection(sectionName).blockSeat();
  }

  public void unBlockSeat(String sectionName, int seatNo) {
    getSection(sectionName).unBlockSeat(seatNo);
  }
}
