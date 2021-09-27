//
//  CafeObservable.swift
//  iosApp
//
//  Created by yuli on 2021/9/26.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared
import SwiftUI
class CafeObservable: ObservableObject {
    @Published var cafeResponseItemList = [CafeResponseItem]()

    private let repository: DataRepository
    var koinApp :Koin_coreKoin

    init(repository: DataRepository) {
        self.repository = repository
        self.koinApp = koin
    }
    
    func fetch() {
        repository.fetchCafesFromNetwork(cityName:"taipei"){ result , error in
            if let result = result{
                self.cafeResponseItemList = result
            }
        }
    }
}
