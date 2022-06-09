import { Observable } from 'rxjs';
import { WeatherStation } from './../../models/weather-station.model';
import { Component, Input, OnInit } from '@angular/core';
import {
  CloudsDescription,
  TemperatureUnit,
} from '../../models/weather-enum.model';
import { WeatherStationService } from '../../services/weather-station.service';

@Component({
  selector: 'app-weather-card',
  templateUrl: './weather-card.component.html',
  styleUrls: ['./weather-card.component.scss'],
})
export class WeatherCardComponent implements OnInit {
  @Input() stationId!: string;
  station!: Observable<WeatherStation>;

  constructor(private weatherStationService: WeatherStationService) {}

  ngOnInit(): void {
    this.station = this.weatherStationService.getWeatherStation(this.stationId);
  }

  getTemperatureUnit(temperatureUnit: TemperatureUnit) {
    switch (temperatureUnit) {
      case TemperatureUnit.CELSIUS:
        return '˚C';
      case TemperatureUnit.FAHRENHEIT:
        return '˚F';
      default:
        throw 'Unit not implemented';
    }
  }
  getCloudsDescription(cloudsDescription: CloudsDescription) {
    switch (cloudsDescription) {
      case CloudsDescription.CLOUDY:
        return 'Cloudy';
      case CloudsDescription.PART_CLOUDY:
        return 'Part Cloudy';
      case CloudsDescription.STORMY:
        return 'Stormy';
      case CloudsDescription.SUNNY:
        return 'Sunny';
      default:
        throw 'Description not implemented';
    }
  }
}
