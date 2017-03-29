package util;

public class linker{

/* The basic idea is to store the id's that link together. I had a thought to
    store them in an array list of each type of id but i want to run that past
    you guys first. */

  private int idCon;
  private int idEve;
  private int idCour;
  private int idNote;

  public linker(){
    //still very unsure if there is anyway to build a variable sized constructor
    //need to discuss and look into ths some more
  }

  private void setContact(int conId){
    idCon = conId;
  }

  private void setEvent(int eveId){
    idEve = eveId;
  }

  private void setCourse(int corsId){
    idCour = corsId;
  }

  private void setNote(int notId){
    idNote = notId;
  }

  private int getContact(){
    return idCon;
  }

  private int getEvent(){
    return idEve;
  }

  private int getCourse(){
    return idCour;
  }

  private int getNote(){
    return idNote;
  }



}
