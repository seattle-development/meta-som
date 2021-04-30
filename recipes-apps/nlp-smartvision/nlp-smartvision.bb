SUMMARY = "nlp smartvision application"

LICENSE = "Apache-2.0 & GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a9c5ded2ac97b4ce01aa0ace8f3a1755 \
		    file://CMSIS/LICENSE.txt;md5=e3fc50a88d0a364313df4b21ef20c29e \
		    file://Hello_edge/src/LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e \
		    file://src/COPYING;md5=59530bdf33659b29e73d4adb9f9f6552 \
		    "

BRANCH = "release-2020.2.2_k26"
SRC_URI = "git://github.com/Xilinx/nlp-smartvision.git;protocol=https;branch=${BRANCH}"
SRCREV = "f9a087104d18acaf6a431e3407911948705d2d50"

inherit cmake

DEPENDS = "glog opencv vitis-ai-library vart"
RDEPENDS_${PN} = " \
	gst-perf \
	gstreamer1.0-omx \
	gstreamer1.0-plugins-bad-kms \
	gstreamer1.0-plugins-bad-mediasrcbin \
	gstreamer1.0-plugins-bad-videoparsersbad \
	gstreamer1.0-plugins-good-video4linux2 \
	gstreamer1.0-python \
	libdrm-tests \
	v4l-utils \
	alsa-utils \
	${@bb.utils.contains('DISTRO_FEATURES', 'pulseaudio', 'pulseaudio-server pulseaudio-client-conf-sato pulseaudio-misc', '', d)} \
	libasound \
	"

SOMAPP_INSTALL_PATH = "/"
EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release -DCMAKE_SYSROOT=${STAGING_DIR_HOST} -DCMAKE_INSTALL_PREFIX=${SOMAPP_INSTALL_PATH} "

S = "${WORKDIR}/git"

FILES_${PN} += " \
	/opt/xilinx \
	"
