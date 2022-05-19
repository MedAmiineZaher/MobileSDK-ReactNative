require "json"

package = JSON.parse(File.read(File.join(__dir__, "package.json")))

Pod::Spec.new do |s|
  s.name         = "RNSelligent"
  s.authors      = { 'AppFoundry' => 'info@appfoundry.be' }
  s.version      = package["version"]
  s.summary      = package["description"]
  s.description  = <<-DESC
                  RNSelligent
                   DESC
  s.homepage     = "https://github.com/SelligentMarketingCloud/MobileSDK-ReactNative"
  s.license      = "MIT"
  s.platform     = :ios, "11.0"
  s.source       = { :git => "https://github.com/SelligentMarketingCloud/MobileSDK-ReactNative.git", :tag => "#{s.version}" }

  s.source_files = "ios/**/*.{h,m}"
  s.requires_arc = true

  s.vendored_libraries = "ios/libSelligentMobile.a"
  s.libraries = "SelligentMobile"

  s.dependency "React"
  s.dependency "PlotPlugin"
end

  
