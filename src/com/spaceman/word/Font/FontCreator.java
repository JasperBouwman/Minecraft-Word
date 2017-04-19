package com.spaceman.word.font;

import com.spaceman.word.Main;
import com.spaceman.word.font.capitals.A;
import com.spaceman.word.font.capitals.B;
import com.spaceman.word.font.capitals.C;
import com.spaceman.word.font.capitals.D;
import com.spaceman.word.font.capitals.E;
import com.spaceman.word.font.capitals.F;
import com.spaceman.word.font.capitals.G;
import com.spaceman.word.font.capitals.H;
import com.spaceman.word.font.capitals.I;
import com.spaceman.word.font.capitals.J;
import com.spaceman.word.font.capitals.K;
import com.spaceman.word.font.capitals.L;
import com.spaceman.word.font.capitals.M;
import com.spaceman.word.font.capitals.N;
import com.spaceman.word.font.capitals.O;
import com.spaceman.word.font.capitals.P;
import com.spaceman.word.font.capitals.Q;
import com.spaceman.word.font.capitals.R;
import com.spaceman.word.font.capitals.S;
import com.spaceman.word.font.capitals.T;
import com.spaceman.word.font.capitals.U;
import com.spaceman.word.font.capitals.V;
import com.spaceman.word.font.capitals.W;
import com.spaceman.word.font.capitals.X;
import com.spaceman.word.font.capitals.Y;
import com.spaceman.word.font.capitals.Z;
import com.spaceman.word.font.numbers.N0;
import com.spaceman.word.font.numbers.N1;
import com.spaceman.word.font.numbers.N2;
import com.spaceman.word.font.numbers.N3;
import com.spaceman.word.font.numbers.N4;
import com.spaceman.word.font.numbers.N5;
import com.spaceman.word.font.numbers.N6;
import com.spaceman.word.font.numbers.N7;
import com.spaceman.word.font.numbers.N8;
import com.spaceman.word.font.numbers.N9;
import com.spaceman.word.font.other.E01;
import com.spaceman.word.font.other.E02;
import com.spaceman.word.font.other.E03;
import com.spaceman.word.font.other.E04;
import com.spaceman.word.font.other.E05;
import com.spaceman.word.font.other.E06;
import com.spaceman.word.font.other.E07;
import com.spaceman.word.font.other.E08;
import com.spaceman.word.font.other.E09;
import com.spaceman.word.font.other.E10;
import com.spaceman.word.font.other.E11;
import com.spaceman.word.font.other.E12;
import com.spaceman.word.font.other.E13;
import com.spaceman.word.font.other.E14;
import com.spaceman.word.font.other.E15;
import com.spaceman.word.font.other.E16;
import com.spaceman.word.font.other.E17;
import com.spaceman.word.font.other.E18;
import com.spaceman.word.font.other.E19;
import com.spaceman.word.font.other.E20;
import com.spaceman.word.font.other.E21;
import com.spaceman.word.font.other.E22;
import com.spaceman.word.font.other.E23;
import com.spaceman.word.font.other.E24;
import com.spaceman.word.font.other.E25;
import com.spaceman.word.font.other.E26;
import com.spaceman.word.font.other.E27;
import com.spaceman.word.font.other.E28;
import com.spaceman.word.font.other.E29;
import com.spaceman.word.font.other.E30;
import com.spaceman.word.font.other.E31;
import com.spaceman.word.font.other.E32;
import com.spaceman.word.font.other.Unsupported;
import com.spaceman.word.font.small.a;
import com.spaceman.word.font.small.b;
import com.spaceman.word.font.small.c;
import com.spaceman.word.font.small.d;
import com.spaceman.word.font.small.e;
import com.spaceman.word.font.small.f;
import com.spaceman.word.font.small.g;
import com.spaceman.word.font.small.h;
import com.spaceman.word.font.small.i;
import com.spaceman.word.font.small.j;
import com.spaceman.word.font.small.k;
import com.spaceman.word.font.small.l;
import com.spaceman.word.font.small.m;
import com.spaceman.word.font.small.n;
import com.spaceman.word.font.small.o;
import com.spaceman.word.font.small.p;
import com.spaceman.word.font.small.q;
import com.spaceman.word.font.small.r;
import com.spaceman.word.font.small.s;
import com.spaceman.word.font.small.t;
import com.spaceman.word.font.small.u;
import com.spaceman.word.font.small.v;
import com.spaceman.word.font.small.w;
import com.spaceman.word.font.small.x;
import com.spaceman.word.font.small.y;
import com.spaceman.word.font.small.z;

public class FontCreator {

	Main p;

	public FontCreator(Main instance) {
		p = instance;
	}

	public void Font(String s) {

		if (s.equals("A")) {
			A font = new A(p);
			font.Font();
		} else if (s.equals("a")) {
			a font = new a(p);
			font.Font();
		} else if (s.equals("B")) {
			B font = new B(p);
			font.Font();
		} else if (s.equals("b")) {
			b font = new b(p);
			font.Font();
		} else if (s.equals("C")) {
			C font = new C(p);
			font.Font();
		} else if (s.equals("c")) {
			c font = new c(p);
			font.Font();
		} else if (s.equals("D")) {
			D font = new D(p);
			font.Font();
		} else if (s.equals("d")) {
			d font = new d(p);
			font.Font();
		} else if (s.equals("E")) {
			E font = new E(p);
			font.Font();
		} else if (s.equals("e")) {
			e font = new e(p);
			font.Font();
		} else if (s.equals("F")) {
			F font = new F(p);
			font.Font();
		} else if (s.equals("f")) {
			f font = new f(p);
			font.Font();
		} else if (s.equals("G")) {
			G font = new G(p);
			font.Font();
		} else if (s.equals("g")) {
			g font = new g(p);
			font.Font();
		} else if (s.equals("H")) {
			H font = new H(p);
			font.Font();
		} else if (s.equals("h")) {
			h font = new h(p);
			font.Font();
		} else if (s.equals("I")) {
			I font = new I(p);
			font.Font();
		} else if (s.equals("i")) {
			i font = new i(p);
			font.Font();
		} else if (s.equals("J")) {
			J font = new J(p);
			font.Font();
		} else if (s.equals("j")) {
			j font = new j(p);
			font.Font();
		} else if (s.equals("K")) {
			K font = new K(p);
			font.Font();
		} else if (s.equals("k")) {
			k font = new k(p);
			font.Font();
		} else if (s.equals("L")) {
			L font = new L(p);
			font.Font();
		} else if (s.equals("l")) {
			l font = new l(p);
			font.Font();
		} else if (s.equals("M")) {
			M font = new M(p);
			font.Font();
		} else if (s.equals("m")) {
			m font = new m(p);
			font.Font();
		} else if (s.equals("N")) {
			N font = new N(p);
			font.Font();
		} else if (s.equals("n")) {
			n font = new n(p);
			font.Font();
		} else if (s.equals("O")) {
			O font = new O(p);
			font.Font();
		} else if (s.equals("o")) {
			o font = new o(p);
			font.Font();
		} else if (s.equals("P")) {
			P font = new P(p);
			font.Font();
		} else if (s.equals("p")) {
			p font = new p(p);
			font.Font();
		} else if (s.equals("Q")) {
			Q font = new Q(p);
			font.Font();
		} else if (s.equals("q")) {
			q font = new q(p);
			font.Font();
		} else if (s.equals("R")) {
			R font = new R(p);
			font.Font();
		} else if (s.equals("r")) {
			r font = new r(p);
			font.Font();
		} else if (s.equals("S")) {
			S font = new S(p);
			font.Font();
		} else if (s.equals("s")) {
			s font = new s(p);
			font.Font();
		} else if (s.equals("T")) {
			T font = new T(p);
			font.Font();
		} else if (s.equals("t")) {
			t font = new t(p);
			font.Font();
		} else if (s.equals("U")) {
			U font = new U(p);
			font.Font();
		} else if (s.equals("u")) {
			u font = new u(p);
			font.Font();
		} else if (s.equals("V")) {
			V font = new V(p);
			font.Font();
		} else if (s.equals("v")) {
			v font = new v(p);
			font.Font();
		} else if (s.equals("W")) {
			W font = new W(p);
			font.Font();
		} else if (s.equals("w")) {
			w font = new w(p);
			font.Font();
		} else if (s.equals("X")) {
			X font = new X(p);
			font.Font();
		} else if (s.equals("x")) {
			x font = new x(p);
			font.Font();
		} else if (s.equals("Y")) {
			Y font = new Y(p);
			font.Font();
		} else if (s.equals("y")) {
			y font = new y(p);
			font.Font();
		} else if (s.equals("Z")) {
			Z font = new Z(p);
			font.Font();
		} else if (s.equals("z")) {
			z font = new z(p);
			font.Font();
		} else if (s.equals("1")) {
			N1 font = new N1(p);
			font.Font();
		} else if (s.equals("2")) {
			N2 font = new N2(p);
			font.Font();
		} else if (s.equals("3")) {
			N3 font = new N3(p);
			font.Font();
		} else if (s.equals("4")) {
			N4 font = new N4(p);
			font.Font();
		} else if (s.equals("5")) {
			N5 font = new N5(p);
			font.Font();
		} else if (s.equals("6")) {
			N6 font = new N6(p);
			font.Font();
		} else if (s.equals("7")) {
			N7 font = new N7(p);
			font.Font();
		} else if (s.equals("8")) {
			N8 font = new N8(p);
			font.Font();
		} else if (s.equals("9")) {
			N9 font = new N9(p);
			font.Font();
		} else if (s.equals("0")) {
			N0 font = new N0(p);
			font.Font();
		} else if (s.equals(",")) {
			E01 font = new E01(p);
			font.Font();
		} else if (s.equals("<")) {
			E02 font = new E02(p);
			font.Font();
		} else if (s.equals(".")) {
			E03 font = new E03(p);
			font.Font();
		} else if (s.equals(">")) {
			E04 font = new E04(p);
			font.Font();
		} else if (s.equals("/")) {
			E05 font = new E05(p);
			font.Font();
		} else if (s.equals("?")) {
			E06 font = new E06(p);
			font.Font();
		} else if (s.equals(";")) {
			E07 font = new E07(p);
			font.Font();
		} else if (s.equals(":")) {
			E08 font = new E08(p);
			font.Font();
		} else if (s.equals("'")) {
			E09 font = new E09(p);
			font.Font();
		} else if (s.equals("\"")) {
			E10 font = new E10(p);
			font.Font();
		} else if (s.equals("{")) {
			E11 font = new E11(p);
			font.Font();
		} else if (s.equals("[")) {
			E12 font = new E12(p);
			font.Font();
		} else if (s.equals("}")) {
			E13 font = new E13(p);
			font.Font();
		} else if (s.equals("]")) {
			E14 font = new E14(p);
			font.Font();
		} else if (s.equals("|")) {
			E15 font = new E15(p);
			font.Font();
		} else if (s.equals("\\")) {
			E16 font = new E16(p);
			font.Font();
		} else if (s.equals("`")) {
			E17 font = new E17(p);
			font.Font();
		} else if (s.equals("~")) {
			E18 font = new E18(p);
			font.Font();
		} else if (s.equals("!")) {
			E19 font = new E19(p);
			font.Font();
		} else if (s.equals("@")) {
			E20 font = new E20(p);
			font.Font();
		} else if (s.equals("$")) {
			E21 font = new E21(p);
			font.Font();
		} else if (s.equals("%")) {
			E22 font = new E22(p);
			font.Font();
		} else if (s.equals("^")) {
			E23 font = new E23(p);
			font.Font();
		} else if (s.equals("&")) {
			E24 font = new E24(p);
			font.Font();
		} else if (s.equals("*")) {
			E25 font = new E25(p);
			font.Font();
		} else if (s.equals("(")) {
			E26 font = new E26(p);
			font.Font();
		} else if (s.equals(")")) {
			E27 font = new E27(p);
			font.Font();
		} else if (s.equals("_")) {
			E28 font = new E28(p);
			font.Font();
		} else if (s.equals("-")) {
			E29 font = new E29(p);
			font.Font();
		} else if (s.equals("=")) {
			E30 font = new E30(p);
			font.Font();
		} else if (s.equals("+")) {
			E31 font = new E31(p);
			font.Font();
		} else if (s.equals("#")) {
			E32 font = new E32(p);
			font.Font();
		} else {
			Unsupported font = new Unsupported(p);
			font.Font();
		}
	}
}
