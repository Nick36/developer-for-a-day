import { WeatherStation } from './../../models/weather-station.model';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-weather-icon',
  templateUrl: './weather-icon.component.html',
  styleUrls: ['./weather-icon.component.scss'],
})
export class WeatherIconComponent implements OnInit {
  @Input() weather!: WeatherStation;

  constructor() {}

  ngOnInit(): void {}
}
