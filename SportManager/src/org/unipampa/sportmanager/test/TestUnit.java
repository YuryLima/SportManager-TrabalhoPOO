package org.unipampa.sportmanager.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.unipampa.sportmanager.aluno.Aluno;
import org.unipampa.sportmanager.esportes.Esporte;
import org.unipampa.sportmanager.esportes.Turma;

public class TestUnit {

	private Aluno aluno1;
	private Aluno aluno2;
	private Aluno aluno3;
	private Aluno aluno4;
	private Turma turma1;

	@Before
	public void before() {
		this.aluno1 = new Aluno("Samuel alexandre", 15);
		this.aluno2 = new Aluno("Samuel alexandre", 15);
		this.aluno3 = new Aluno("Denner Ribeiro", 18);
		this.aluno4 = new Aluno("Kauã Lucas", 12);
		this.turma1 = new Turma(10, Esporte.FUTEBOL, 2, 17, 18);

	}

	@Test
	public void testAddAlunoEquals() {

		Assert.assertTrue(turma1.addAluno(aluno1));
		Assert.assertFalse(turma1.addAluno(aluno1));

	}

	@Test
	public void testAddMAX_ALUNO() {

		Assert.assertTrue(turma1.addAluno(aluno1));
		Assert.assertTrue(turma1.addAluno(aluno2));
		Assert.assertFalse(turma1.addAluno(aluno3));
	}

	@Test
	public void testRemoveAluno() {
		Aluno aluno10 = new Aluno("Yury", 22);
		turma1.addAluno(aluno10);
		Assert.assertTrue(turma1.removeAluno(aluno10.getSequence()));
	}

	@Test
	public void testPrivate() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

		
		Aluno a = new Aluno("Yury Alencar", 22);

		
		Class<?> aluno = Aluno.class;

		
		Method[] methods = aluno.getDeclaredMethods();

		
		for (int i = 0; i < methods.length; i++) {
			if (methods[i].getName().equals("getSequence")) {

				
				methods[i].setAccessible(true);

				
				System.out.println(methods[i].invoke(a));
			}
		}

		Field[] field = aluno.getDeclaredFields();

		for (int i = 0; i < field.length; i++) {
			if (field[i].getName().equals("nomeCompleto")) {
				field[i].setAccessible(true);

				System.out.println(field[i].get(a));
				field[i].set(a, "Samuel");

				System.out.println(field[i].get(a));
			}
		}
	}
}

