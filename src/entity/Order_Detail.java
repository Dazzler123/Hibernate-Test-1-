package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity(name = "order_detail")
public class Order_Detail {
    @Id
    private String id;

    @ManyToOne
    private Orders orders;

    @ManyToOne
    private Item item;

    private int qty;  //item qty bought
}
