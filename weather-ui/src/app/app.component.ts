import { WeatherStationService } from './services/weather-station.service';
import { WeatherStation } from './models/weather-station.model';
import { Component, OnInit } from '@angular/core';
import { WeatherMap } from './models/weather-map.model';
import { Observable, startWith, Subject, switchMap, tap } from 'rxjs';
import { FormBuilder, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  weatherStations: Observable<string[]>;
  weatherForm = this.formBuilder.group({ station: ['', Validators.required] });
  triggerWeatherFetch = new Subject<null>();

  constructor(
    private weatherStationService: WeatherStationService,
    private formBuilder: FormBuilder
  ) {
    this.weatherStations = this.triggerWeatherFetch.pipe(
      startWith(null),
      switchMap(() => this.weatherStationService.getStations())
    );
  }

  onRefreshStations() {
    this.triggerWeatherFetch.next(null);
  }

  onAddStation() {
    // TODO Implement Add Station
  }

  onDeleteAllStations() {
    // TODO Implement Delete All Stations
  }

  onDeleteStation(stationId: string) {
    // TODO Implement Delete Station
  }
}
