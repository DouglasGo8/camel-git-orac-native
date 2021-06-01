package br.com.orac.natv.git.mediation;

import org.apache.camel.builder.RouteBuilder;

public class JdbcNativeOps extends RouteBuilder {

    @Override
    public void configure() {

        final String query = "SELECT NR_PRONTUARIO FROM tasy.HCOR_MAPA_LEITO_PA";

        from("timer://foo?period=30s&fixedRate=true").transform(constant(query))

                .to("jdbc:tasy-ds")

                .log("${body}").end();
    }
}
