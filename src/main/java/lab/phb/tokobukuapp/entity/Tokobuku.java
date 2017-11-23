package lab.phb.tokobukuapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
//@Table(name = "mahasiswa")
public class Tokobuku {
    
    @Id
    @Getter @Setter
    private String id;
    
    @Getter @Setter
    private String judul_buku;
    
    @Getter @Setter
    private String harga;
    
}
