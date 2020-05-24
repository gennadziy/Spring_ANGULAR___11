package Spring_ANGULAR.Spring_ANGULAR;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Table
@Entity
@Data
@XmlRootElement(name = "planets")
@XmlAccessorType(XmlAccessType.FIELD)
public class Planets {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name_planet;
    private String url_img;
    private String planet_type;
    private long distance;
    private double One_Way_Light_Time;
    private double Length_of_Year;
    private String descr;

}
