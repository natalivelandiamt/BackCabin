package co.edu.usergioarboleda.alquiler.cabin.app.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.edu.usergioarboleda.alquiler.cabin.app.models.Reservation;
import co.edu.usergioarboleda.alquiler.cabin.app.repository.crud.ReservationCrudRepository;

import java.util.Date;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository repository;
    
    /**
     * Metodo que retorna todas las reservaciones
     * @return List<Reservation>
     */
    public List<Reservation> findAll() {
        return (List<Reservation>) repository.findAll();
    }

    /**
     * Metodo que retorna una reservacion consultada por su id si esta existe
     * @param id
     * @return 
     */
    public Reservation findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Metodo pra guardar una reservacion en DB
     * @param reservation
     * @return
     */
    public Reservation save(Reservation reservation) {
        return repository.save(reservation);
    }


    /**
     * Metodo para eliminar una reservacion usando la instancia completa
     * @param reservation
     */
    public void delete(Reservation reservation) {
        repository.delete(reservation);
    }

    /**
     * Metodo para eliminar una reservacion usando su id
     * @param id
     */
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    /**
     * Metodo que devuelve todas las reservaciones por rango de fechas
     * @param startDate
     * @param endDate
     * @return
     */
    public List<Reservation> findAllByDates(Date fechaInicial, Date fechaFinal) {
        return repository.findAllByStartDateAfterAndStartDateBefore(fechaInicial, fechaFinal);
    }

    /**
     * Metodo que devuelve el top de clientes que mas reservaron
     * 
     * @return List<CountClient> respuesta
     */
    public List<Object[]> findTopClients() {
        return repository.countTotalReservationByClient();
    }

    /**
     * Metodo que devuelve el top de cabinas que mas reservaron
     * 
     * @return List<CountClient> respuesta
     */
    public List<Reservation> findReservationsByStatus(String status) {
        return repository.findAllByStatus(status);
    }
}
