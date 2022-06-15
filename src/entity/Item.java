package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity(name = "item")
public class Item {
    @Id
    private String itemCode;
    private String itemName;
    private double unitPrice;
    private int qty_on_hand;
}
