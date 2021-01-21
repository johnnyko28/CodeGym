import java.io.*;
import java.util.*;

public class CreatingStrings {

	static Set<String> set = new HashSet<>();
	static List<String> list = new ArrayList<>();

	static void permutations(char []a, int l, int r) {
		if (l == r) {
			if (!set.contains(String.valueOf(a))) {
				set.add(String.valueOf(a));
				list.add(String.valueOf(a));
			}
			return;
		}

		else {
			for (int i = l; i <= r; i++) {
				swap(a, l, i);
				permutations(a, l + 1, r);
				swap(a, l, i);
			}
		}
	}

	static void swap(char []a, int l, int r) {
		char temp = a[l];
		a[l] = a[r];
		a[r] = temp;
	}


	public static void main(String[] args)throws IOException {

		InputReader in = new InputReader();
		PrintWriter pw = new PrintWriter(System.out);
		char []s = in.nextLine().toCharArray();
		permutations(s, 0, s.length - 1);
		pw.println(list.size());
		Collections.sort(list);
		for (String i : list)
			pw.println(i);
		pw.close();
	}

	static final Random random = new Random();

	static void ruffleSort(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int oi = random.nextInt(n), temp = a[oi];
			a[oi] = a[i];
			a[i] = temp;
		}
		ArrayList<Integer> lst = new ArrayList<>();
		for (int i : a)
			lst.add(i);
		Collections.sort(lst);
		for (int i = 0; i < n; i++)
			a[i] = lst.get(i);
	}

	static class InputReader {
		BufferedReader br;
		StringTokenizer st;

		public InputReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
		long nextLong() {
			return Long.parseLong(next());
		}
		double nextDouble() {
			return Double.parseDouble(next());
		}
		int[] readArray(int n) {
			int []a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}
		long[] readLongArray(int n) {
			long []a = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
			return a;
		}
		int [][] read2dArray(int n, int m) {
			int [][]a = new int[n][m];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < m; j++)
					a[i][j] = nextInt();
			return a;
		}
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}