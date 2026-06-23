package ec.edu.uce;

import java.math.BigDecimal;

import ec.edu.uce.aplication.service.CuentaService;
import ec.edu.uce.aplication.service.TransferenciaService;
import ec.edu.uce.domain.model.Cuenta;
import ec.edu.uce.domain.model.Transferencia;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main {
public static void main(String[] args) {
    Quarkus.run(App.class,args );
}
public static class App implements  QuarkusApplication{
    @Inject
    private TransferenciaService transferenciaService;

    @Inject
    private CuentaService cuentaService;
    @Override
    public int run(String... args) throws Exception {
        System.out.println("Conectado a la base");
        Cuenta cOrigen = new Cuenta();
        cOrigen.setNombre("Andy Suquilandi");
        cOrigen.setSaldo(new BigDecimal(2000));
        

        Cuenta cDestino = new Cuenta();
        cDestino.setNombre("Jhon Cordova");
        cDestino.setSaldo(new BigDecimal(100));
        cuentaService.crear(cOrigen);
        cuentaService.crear(cDestino);

        System.out.println("CUENTAS ANTES DE TRANSFERENCIA ");
        System.out.println( cOrigen.toString());
        System.out.println(cDestino.toString());

        Transferencia transferencia = new Transferencia();
        transferencia.setCuentaOrigen(cOrigen);
        transferencia.setCuentaDestino(cDestino);
        transferencia.setMonto(new BigDecimal(200));
        transferenciaService.crear(transferencia);
        

        transferenciaService.realizar(cOrigen.getId(), cDestino.getId(), transferencia.getMonto());


         System.out.println("CUENTAS DESPUES DE TRANSFERENCIA ");
         System.out.println( cuentaService.findId(1));
         System.out.println( cuentaService.findId(2));
        
        return 0;
    }

}

}
