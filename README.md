[![Stargazers][stars-shield]][stars-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]



<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/juanaviladev/google-popular-times">
   🔎 ⏳
  </a>

<h3 align="center">Google popular times</h3>

  <p align="center">
    A simple library for extracting popular times from a google search
    <br />
    <a href="https://github.com/juanaviladev/google-popular-times"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/juanaviladev/google-popular-times">View Demo</a>
    ·
    <a href="https://github.com/juanaviladev/google-popular-times/issues">Report Bug</a>
    ·
    <a href="https://github.com/juanaviladev/google-popular-times/issues">Request Feature</a>
  </p>
</p>



<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary><h2 style="display: inline-block">Table of Contents</h2></summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#installation">Installation</a>
      <ul>
        <li><a href="#jar-dependency">JAR dependency</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#disclaimer">Disclaimer</a></li>
  </ol>
</details>


<!-- ABOUT THE PROJECT -->

## About The Project

This library is an educational proof of concept about extracting popular times from a simple Google search. It should
not be used in a production ready application.

For example, if you search 'Museo del prado', you will obtain something like this:

```
PopularTimes(days=[Day(status=OPEN, hours=[Hour(hour=6, percent=0, message=), Hour(hour=7, percent=0, message=), Hour(hour=8, percent=0, message=), Hour(hour=9, percent=0, message=), Hour(hour=10, percent=41, message=Usually not too busy), Hour(hour=11, percent=55, message=Usually a little busy), Hour(hour=12, percent=63, message=Usually a little busy), Hour(hour=13, percent=61, message=Usually a little busy), Hour(hour=14, percent=52, message=Usually a little busy), Hour(hour=15, percent=41, message=Usually not too busy), Hour(hour=16, percent=40, message=Usually not too busy), Hour(hour=17, percent=51, message=Usually a little busy), Hour(hour=18, percent=59, message=Usually a little busy), Hour(hour=19, percent=46, message=Usually not too busy), Hour(hour=20, percent=0, message=), Hour(hour=21, percent=0, message=), Hour(hour=22, percent=0, message=), Hour(hour=23, percent=0, message=)]), Day(status=OPEN, hours=[Hour(hour=6, percent=0, message=), Hour(hour=7, percent=0, message=), Hour(hour=8, percent=0, message=), Hour(hour=9, percent=0, message=), Hour(hour=10, percent=47, message=Usually not too busy), Hour(hour=11, percent=63, message=Usually a little busy), Hour(hour=12, percent=70, message=Usually a little busy), Hour(hour=13, percent=67, message=Usually a little busy), Hour(hour=14, percent=54, message=Usually a little busy), Hour(hour=15, percent=42, message=Usually not too busy), Hour(hour=16, percent=40, message=Usually not too busy), Hour(hour=17, percent=54, message=Usually a little busy), Hour(hour=18, percent=65, message=Usually a little busy), Hour(hour=19, percent=52, message=Usually a little busy), Hour(hour=20, percent=0, message=), Hour(hour=21, percent=0, message=), Hour(hour=22, percent=0, message=), Hour(hour=23, percent=0, message=)]), Day(status=OPEN, hours=[Hour(hour=6, percent=0, message=), Hour(hour=7, percent=0, message=), Hour(hour=8, percent=0, message=), Hour(hour=9, percent=0, message=), Hour(hour=10, percent=47, message=Usually not too busy), Hour(hour=11, percent=64, message=Usually a little busy), Hour(hour=12, percent=72, message=Usually a little busy), Hour(hour=13, percent=69, message=Usually a little busy), Hour(hour=14, percent=57, message=Usually a little busy), Hour(hour=15, percent=45, message=Usually not too busy), Hour(hour=16, percent=45, message=Usually not too busy), Hour(hour=17, percent=59, message=Usually a little busy), Hour(hour=18, percent=67, message=Usually a little busy), Hour(hour=19, percent=53, message=Usually a little busy), Hour(hour=20, percent=0, message=), Hour(hour=21, percent=0, message=), Hour(hour=22, percent=0, message=), Hour(hour=23, percent=0, message=)]), Day(status=OPEN, hours=[Hour(hour=6, percent=0, message=), Hour(hour=7, percent=0, message=), Hour(hour=8, percent=0, message=), Hour(hour=9, percent=0, message=), Hour(hour=10, percent=46, message=Usually not too busy), Hour(hour=11, percent=63, message=Usually a little busy), Hour(hour=12, percent=73, message=Usually a little busy), Hour(hour=13, percent=71, message=Usually a little busy), Hour(hour=14, percent=59, message=Usually a little busy), Hour(hour=15, percent=45, message=Usually not too busy), Hour(hour=16, percent=42, message=Usually not too busy), Hour(hour=17, percent=54, message=Usually a little busy), Hour(hour=18, percent=63, message=Usually a little busy), Hour(hour=19, percent=52, message=Usually a little busy), Hour(hour=20, percent=0, message=), Hour(hour=21, percent=0, message=), Hour(hour=22, percent=0, message=), Hour(hour=23, percent=0, message=)]), Day(status=OPEN, hours=[Hour(hour=6, percent=0, message=), Hour(hour=7, percent=0, message=), Hour(hour=8, percent=0, message=), Hour(hour=9, percent=0, message=), Hour(hour=10, percent=50, message=Usually a little busy), Hour(hour=11, percent=72, message=Usually a little busy), Hour(hour=12, percent=84, message=Usually as busy as it gets), Hour(hour=13, percent=80, message=Usually as busy as it gets), Hour(hour=14, percent=64, message=Usually a little busy), Hour(hour=15, percent=49, message=Usually not too busy), Hour(hour=16, percent=49, message=Usually not too busy), Hour(hour=17, percent=61, message=Usually a little busy), Hour(hour=18, percent=66, message=Usually a little busy), Hour(hour=19, percent=51, message=Usually a little busy), Hour(hour=20, percent=0, message=), Hour(hour=21, percent=0, message=), Hour(hour=22, percent=0, message=), Hour(hour=23, percent=0, message=)]), Day(status=OPEN, hours=[Hour(hour=6, percent=0, message=), Hour(hour=7, percent=0, message=), Hour(hour=8, percent=0, message=), Hour(hour=9, percent=0, message=), Hour(hour=10, percent=42, message=Usually not too busy), Hour(hour=11, percent=74, message=Usually a little busy), Hour(hour=12, percent=98, message=Usually as busy as it gets), Hour(hour=13, percent=96, message=Usually as busy as it gets), Hour(hour=14, percent=74, message=Usually a little busy), Hour(hour=15, percent=58, message=Usually a little busy), Hour(hour=16, percent=69, message=Usually a little busy), Hour(hour=17, percent=93, message=Usually as busy as it gets), Hour(hour=18, percent=96, message=Usually as busy as it gets), Hour(hour=19, percent=66, message=Usually a little busy), Hour(hour=20, percent=0, message=), Hour(hour=21, percent=0, message=), Hour(hour=22, percent=0, message=), Hour(hour=23, percent=0, message=)]), Day(status=OPEN, hours=[Hour(hour=6, percent=0, message=), Hour(hour=7, percent=0, message=), Hour(hour=8, percent=0, message=), Hour(hour=9, percent=0, message=), Hour(hour=10, percent=41, message=Usually not too busy), Hour(hour=11, percent=77, message=Usually a little busy), Hour(hour=12, percent=100, message=Usually as busy as it gets), Hour(hour=13, percent=95, message=Usually as busy as it gets), Hour(hour=14, percent=79, message=Usually a little busy), Hour(hour=15, percent=66, message=Usually a little busy), Hour(hour=16, percent=55, message=Usually a little busy), Hour(hour=17, percent=40, message=Usually not too busy), Hour(hour=18, percent=25, message=Usually not too busy), Hour(hour=19, percent=0, message=), Hour(hour=20, percent=0, message=), Hour(hour=21, percent=0, message=), Hour(hour=22, percent=0, message=), Hour(hour=23, percent=0, message=)])])
```

What can the library currently extract?

- ✅ Affluence by hour
- ✅ Message depending the affluence (ex. Usually a little busy)
- ✅ Status (open or closed) by hour

What it doesn't do

- ❌ Extract business hours

### Built With

* [Kotlin](https://kotlinlang.org/)
* [Maven](https://maven.apache.org/)
* [Apache Commons](https://commons.apache.org/)
* [Gson](https://github.com/google/gson)

<!-- Installation -->

## Installation

To get a copy up and running follow these simple steps.

### Jar dependency

* Download from here the [latest release](https://github.com/juanaviladev/google-popular-times/releases) and it on your
  project.

<!-- USAGE EXAMPLES -->

## Usage

Please visit [example module](https://github.com/juanaviladev/LiveRSS-Android/tree/master/example)  to see a fully
working example.

<!-- ROADMAP -->

## Roadmap

See the [open issues](https://github.com/juanaviladev/google-popular-times/issues) for a list of proposed features (and
known issues).

<!-- CONTRIBUTING -->

## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any
contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch from master (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<!-- LICENSE -->

## License

Distributed under the MIT License. See `LICENSE` for more information.

<!-- DISCLAIMER -->

## Disclaimer

This library has been made to be used for educational purposes, please read Google TOS before using it for any other
purpose


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->

[stars-shield]: https://img.shields.io/github/stars/juanaviladev/google-popular-times.svg?style=for-the-badge

[stars-url]: https://github.com/juanaviladev/google-popular-times/stargazers

[issues-shield]: https://img.shields.io/github/issues/juanaviladev/google-popular-times.svg?style=for-the-badge

[issues-url]: https://github.com/juanaviladev/google-popular-times/issues

[license-shield]: https://img.shields.io/github/license/juanaviladev/google-popular-times.svg?style=for-the-badge

[license-url]: https://github.com/juanaviladev/google-popular-times/blob/master/LICENSE

[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555

[linkedin-url]: https://www.linkedin.com/in/juan-avila-catalan/