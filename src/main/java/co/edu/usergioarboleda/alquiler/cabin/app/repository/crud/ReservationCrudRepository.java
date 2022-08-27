package co.edu.usergioarboleda.alquiler.cabin.app.repository.crud;

import org.springframework.data.repository.CrudRepository;
import co.edu.usergioarboleda.alquiler.cabin.app.models.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {

    /**
     * SELECT * FROM reservation WHERE startDate > ? and endDate < ?
     * @param startDate
     * @param endDate
     * @return
     */
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date startDate, Date endDate);

    /**
     * Metodo que cuenta el total de reservaciones agrupado por cliente
     * @return
     */
    @Query(value = "SELECT client_id, count(client_id) as total FROM reservation GROUP BY client_id ORDER BY total DESC", nativeQuery = true)
    public List<Object[]> countTotalReservationByClient();

    /**
     * Metodo que trae a informacion del cliente
     * @param clientID
     * @return
     */
    @Query(value = "SELECT * FROM client WHERE id_client=?1", nativeQuery = true)
    public List<Object[]> bringClient(Integer clientID);

    /**
     * Metodo que consulta las reservaciones por status
     * @param status
     * @return
     */
    public List<Reservation> findAllByStatus(String status);

    /**
     * metodo que trae el total de reservaciones por cabania
     * @return
     */
    @Query(value = "SELECT c.cabin, count(c.cabin) as total FROM reservation c GROUP BY c.cabin ORDER BY total DESC", nativeQuery = true)
    public List<Object[]> countTotalReservationByCabin();

}
