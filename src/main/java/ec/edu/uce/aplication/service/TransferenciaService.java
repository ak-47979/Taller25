package ec.edu.uce.aplication.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import ec.edu.uce.domain.model.Transferencia;
import ec.edu.uce.domain.repository.TransferenciaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class TransferenciaService {
    @Inject
    private TransferenciaRepository transferenciaRepository;
     public void crear(Transferencia transferencia){
        this.transferenciaRepository.crear(transferencia);
     }
    public void realizar(Integer idOrigen, Integer idDestino, BigDecimal monto){
         Transferencia transferencia = new Transferencia();
        transferencia.setCuentaOrigen(cOrigen);
        transferencia.setCuentaDestino(cDestino);
        transferencia.setMonto(new BigDecimal(200));
        transferencia.setFecha(LocalDate.now());
        transferenciaService.crear(transferencia);
        this.transferenciaRepository.realizar(idOrigen, idDestino, monto);
    }
}
