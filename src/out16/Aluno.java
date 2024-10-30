package out16;

public class Aluno {
	private int idAluno;
	private String alunoNome;
	private String alunoTelefone;
	private double alunoNota;
	
	/**
	 * @param idAluno
	 * @param alunoNome
	 * @param alunoTelefone
	 * @param alunoNota
	 */
	public Aluno(int idAluno, String alunoNome, String alunoTelefone, double alunoNota) {
		
		this.idAluno = idAluno;
		this.alunoNome = alunoNome;
		this.alunoTelefone = alunoTelefone;
		this.alunoNota = alunoNota;
	}
	/**
	 * 
	 */
	public Aluno() {
		
	}
	public int getIdAluno() {
		return idAluno;
	}
	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}
	public String getAlunoNome() {
		return alunoNome;
	}
	public void setAlunoNome(String alunoNome) {
		this.alunoNome = alunoNome;
	}
	public String getAlunoTelefone() {
		return alunoTelefone;
	}
	public void setAlunoTelefone(String alunoTelefone) {
		this.alunoTelefone = alunoTelefone;
	}
	public double getAlunoNota() {
		return alunoNota;
	}
	public void setAlunoNota(double alunoNota) {
		this.alunoNota = alunoNota;
	}
	@Override
	public String toString() {
		return "ID = " + idAluno + ", Nome = " + alunoNome + ", Telefone = " + alunoTelefone + ", "
				+ "Nota = " + alunoNota;
	}
	public void imprimirAluno() {
		System.out.format("\n%-4d %-30s %-25s %,4.2f",
				getIdAluno(),getAlunoNome(),getAlunoTelefone(),getAlunoNota());
	}
}
