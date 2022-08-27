/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usergioarboleda.alquiler.cabin.app.models.custom;

import co.edu.usergioarboleda.alquiler.cabin.app.models.Client;
import java.io.Serializable;
import java.math.BigInteger;

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
public class CountClient implements Serializable {

    private static final long serialVersionUID = 8L;

    private BigInteger total;
    private Client client;

}
