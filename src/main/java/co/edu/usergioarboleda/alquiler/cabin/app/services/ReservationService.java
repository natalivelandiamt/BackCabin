package co.edu.usergioarboleda.alquiler.cabin.app.services;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usergioarboleda.alquiler.cabin.app.models.Reservation;
import co.edu.usergioarboleda.alquiler.cabin.app.models.custom.CountClient;
import co.edu.usergioarboleda.alquiler.cabin.app.models.custom.StatusAmount;
import co.edu.usergioarboleda.alquiler.cabin.app.repository.ClientRepository;
import co.edu.usergioarboleda.alquiler.cabin.app.repository.ReservationRepository;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository repository;

    @Autowired
    private ClientRepository repositoryClient;

    /**
     * Metodo que obtiene una reservacion por su id
     * @param id
     * @return Reservation
     */
    public Reservation getById(Integer id) {
        return repository.findById(id);
    }

    /**
     * Metodo para obtener una lista de todas las reservaciones
     * @return
     */
    public List<Reservation> getAll() {
        return (List<Reservation>) repository.findAll();
    }

    /**
     * Metodo para borrar una reservacion por su id
     * @param id
     */
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    /**
     * Metodo para borrar una reservaciones usando su instancia
     * @param reservation
     */
    public void delete(Reservation reservation) {
        repository.delete(reservation);
    }

    /**
     * metodo para guardar una reservacion
     * @param reservation
     * @return
     */
    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return repository.save(reservation);
        } else {
            if (repository.findById(reservation.getIdReservation()) == null) {
                return repository.save(reservation);
            } else {
                return reservation;
            }
        }
    }

    /**
     * Metodo para actualizar una reservaciones
     * @param reservation
     * @return
     */
    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Reservation newReservation = repository.findById(reservation.getIdReservation());
            if (newReservation != null) {
                if (reservation.getCabin() != null) {
                    newReservation.setCabin(reservation.getCabin());
                }
                if (reservation.getClient() != null) {
                    newReservation.setClient(reservation.getClient());
                }
                if (reservation.getStartDate() != null) {
                    newReservation.setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    newReservation.setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    newReservation.setStatus(reservation.getStatus());
                }
                return repository.save(newReservation);
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }

    public List<Reservation> getReportDates(String fechaInicial, String fechaFinal) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaInicialDate = new Date();
        Date fechaFinalDate = new Date();
        try {
            fechaInicialDate = formatter.parse(fechaInicial);
            fechaFinalDate = formatter.parse(fechaFinal);
            if (fechaInicialDate.before(fechaFinalDate)) {
                return repository.findAllByDates(fechaInicialDate, fechaFinalDate);
            } else {
                return new ArrayList<Reservation>();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<Reservation>();
        }
    }

    /**
     * Metodo que devuelve el top de clientes que mas reservaron
     * 
     * @return List<CountClient> respuesta
     */

    public List<CountClient> getTopClients() {
        List<CountClient> respuesta = new ArrayList<>();
        List<Object[]> reporte = repository.findTopClients();
        for (Object[] object : reporte) {
            respuesta.add(new CountClient((BigInteger) object[1], repositoryClient.findById((Integer) object[0])));
        }
        return respuesta;
    }

    public StatusAmount getReservationStatusReport() {
        List<Reservation> completed = repository.findReservationsByStatus("completed");
        List<Reservation> cancelled = repository.findReservationsByStatus("cancelled");

        return new StatusAmount(completed.size(), cancelled.size());
    }
}
