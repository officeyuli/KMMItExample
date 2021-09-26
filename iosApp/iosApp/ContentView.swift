import SwiftUI
import shared

struct ContentView: View {
    @ObservedObject var cafeObservable =  CafeObservable(repository:DataRepository())

	let greet = Greeting().greeting()

	var body: some View {
        NavigationView {
                    List(cafeObservable.cafeResponseItemList, id: \.id) { cafe in
                        Text(cafe.name)
                    }
                    .navigationBarTitle(Text("CafeList"), displayMode: .large)
                    .onAppear(perform: {
                        self.cafeObservable.fetch()
                    })
                }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
