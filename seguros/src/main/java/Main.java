import br.unibh.seguros.entidades.Desconto;
import br.unibh.seguros.negocio.ServicoDesconto;

public class Main {

	
	public static void main(String[] args) throws Exception {
		ServicoDesconto dao = new ServicoDesconto();
		Desconto desc = new Desconto();
		dao.insert(desc);
	}
}
