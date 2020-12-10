data class OperatingSystem(var name: String = "system name")
data class DualBoot(var primaryOs: OperatingSystem = OperatingSystem(), var secondaryOs: OperatingSystem = OperatingSystem())
