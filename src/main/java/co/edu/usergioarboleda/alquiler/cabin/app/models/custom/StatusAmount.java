/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usergioarboleda.alquiler.cabin.app.models.custom;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author ncastelblanco
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusAmount implements Serializable {
    
    private static final long serialVersionUID = 9L;
    
    private int completed;
    private int cancelled;
}
