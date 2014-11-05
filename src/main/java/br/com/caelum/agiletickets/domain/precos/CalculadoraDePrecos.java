package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;
import br.com.caelum.agiletickets.models.TipoDeEspetaculo;

public class CalculadoraDePrecos {

	public static BigDecimal calcula(Sessao sessao, Integer quantidade) {
		TipoDeEspetaculo tipo = sessao.getEspetaculo().getTipo();
		
		if(tipo.isDeveCalcular()){
			return calculaPreco(sessao, tipo.getPar1(), tipo.getPar2(), tipo.isDeveCalcularMaior60()).multiply(BigDecimal.valueOf(quantidade));
		}
		
		return sessao.getPreco().multiply(BigDecimal.valueOf(quantidade));
	}

	private static BigDecimal calculaPreco(Sessao sessao, double par1,
			double par2, boolean deveCalcularMaior60) {
		BigDecimal preco;
		
		preco = calculaPrecoPadrao(sessao, par1, par2);
		
		if(deveCalcularMaior60){
			preco = calculaPrecoComDuracaoMaiorQue60(sessao, preco);
		}
		
		return preco;
	}

	private static BigDecimal calculaPrecoPadrao(Sessao sessao, Double par1,
			Double par2) {
		BigDecimal preco;
		if((sessao.getTotalIngressos() - sessao.getIngressosReservados()) / sessao.getTotalIngressos().doubleValue() <= par1) { 
			preco = sessao.getPreco().add(sessao.getPreco().multiply(BigDecimal.valueOf(par2)));
		} else {
			preco = sessao.getPreco();
		}
		return preco;
	}

	private static BigDecimal calculaPrecoComDuracaoMaiorQue60(Sessao sessao,
			BigDecimal preco) {
		if(sessao.getDuracaoEmMinutos() > 60){
			preco = preco.add(sessao.getPreco().multiply(BigDecimal.valueOf(0.10)));
		}
		return preco;
	}

}