package com.gamerum.backend.external.client.api.igdb

import com.gamerum.backend.external.client.api.igdb.exception.RequestException
import com.gamerum.backend.external.client.api.igdb.utils.Endpoint
import com.gamerum.backend.external.client.api.igdb.utils.QueryBuilder
import proto.*
import proto.Collection

@Throws(RequestException::class)
fun IGDBApi.ageRatings(QueryBuilder: QueryBuilder): List<AgeRating> {
    val bytes = protoRequest(Endpoint.AGE_RATINGS, QueryBuilder.build())
    return AgeRatingResult.parseFrom(bytes).ageratingsList
}

@Throws(RequestException::class)
fun IGDBApi.ageRatingContentDescriptions(QueryBuilder: QueryBuilder): List<AgeRatingContentDescription> {
    val bytes = protoRequest(Endpoint.AGE_RATING_CONTENT_DESCRIPTIONS, QueryBuilder.build())
    return AgeRatingContentDescriptionResult.parseFrom(bytes).ageratingcontentdescriptionsList
}

@Throws(RequestException::class)
fun IGDBApi.alternativeNames(QueryBuilder: QueryBuilder): List<AlternativeName> {
    val bytes = protoRequest(Endpoint.ALTERNATIVE_NAMES, QueryBuilder.build())
    return AlternativeNameResult.parseFrom(bytes).alternativenamesList
}

@Throws(RequestException::class)
fun IGDBApi.artworks(QueryBuilder: QueryBuilder): List<Artwork> {
    val bytes = protoRequest(Endpoint.ARTWORKS, QueryBuilder.build())
    return ArtworkResult.parseFrom(bytes).artworksList
}

@Throws(RequestException::class)
fun IGDBApi.characters(QueryBuilder: QueryBuilder): List<Character> {
    val bytes = protoRequest(Endpoint.CHARACTERS, QueryBuilder.build())
    return CharacterResult.parseFrom(bytes).charactersList
}

@Throws(RequestException::class)
fun IGDBApi.collections(QueryBuilder: QueryBuilder): List<Collection> {
    val bytes = protoRequest(Endpoint.COLLECTIONS, QueryBuilder.build())
    return CollectionResult.parseFrom(bytes).collectionsList
}

@Throws(RequestException::class)
fun IGDBApi.characterMugShots(QueryBuilder: QueryBuilder): List<CharacterMugShot> {
    val bytes = protoRequest(Endpoint.CHARACTER_MUG_SHOTS, QueryBuilder.build())
    return CharacterMugShotResult.parseFrom(bytes).charactermugshotsList
}

@Throws(RequestException::class)
fun IGDBApi.companies(QueryBuilder: QueryBuilder): List<Company> {
    val bytes = protoRequest(Endpoint.COMPANIES, QueryBuilder.build())
    return CompanyResult.parseFrom(bytes).companiesList
}

@Throws(RequestException::class)
fun IGDBApi.companyWebsites(QueryBuilder: QueryBuilder): List<CompanyWebsite> {
    val bytes = protoRequest(Endpoint.COMPANY_WEBSITES, QueryBuilder.build())
    return CompanyWebsiteResult.parseFrom(bytes).companywebsitesList
}

@Throws(RequestException::class)
fun IGDBApi.companyLogos(QueryBuilder: QueryBuilder): List<CompanyLogo> {
    val bytes = protoRequest(Endpoint.COMPANY_LOGOS, QueryBuilder.build())
    return CompanyLogoResult.parseFrom(bytes).companylogosList
}

@Throws(RequestException::class)
fun IGDBApi.covers(QueryBuilder: QueryBuilder): List<Cover> {
    val bytes = protoRequest(Endpoint.COVERS, QueryBuilder.build())
    return CoverResult.parseFrom(bytes).coversList
}

@Throws(RequestException::class)
fun IGDBApi.externalGames(QueryBuilder: QueryBuilder): List<ExternalGame> {
    val bytes = protoRequest(Endpoint.EXTERNAL_GAMES, QueryBuilder.build())
    return ExternalGameResult.parseFrom(bytes).externalgamesList
}

@Throws(RequestException::class)
fun IGDBApi.franchises(QueryBuilder: QueryBuilder): List<Franchise> {
    val bytes = protoRequest(Endpoint.FRANCHISES, QueryBuilder.build())
    return FranchiseResult.parseFrom(bytes).franchisesList
}

@Throws(RequestException::class)
fun IGDBApi.games(QueryBuilder: QueryBuilder): List<Game> {
    val bytes = protoRequest(Endpoint.GAMES, QueryBuilder.build())
    return GameResult.parseFrom(bytes).gamesList
}

@Throws(RequestException::class)
fun IGDBApi.gameEngines(QueryBuilder: QueryBuilder): List<GameEngine> {
    val bytes = protoRequest(Endpoint.GAME_ENGINES, QueryBuilder.build())
    return GameEngineResult.parseFrom(bytes).gameenginesList
}

@Throws(RequestException::class)
fun IGDBApi.gameEngineLogos(QueryBuilder: QueryBuilder): List<GameEngineLogo> {
    val bytes = protoRequest(Endpoint.GAME_ENGINE_LOGOS, QueryBuilder.build())
    return GameEngineLogoResult.parseFrom(bytes).gameenginelogosList
}

@Throws(RequestException::class)
fun IGDBApi.gameLocalizations(QueryBuilder: QueryBuilder): List<GameLocalization> {
    val bytes = protoRequest(Endpoint.GAME_LOCALIZATIONS, QueryBuilder.build())
    return GameLocalizationResult.parseFrom(bytes).gamelocalizationsList
}

@Throws(RequestException::class)
fun IGDBApi.gameModes(QueryBuilder: QueryBuilder): List<GameMode> {
    val bytes = protoRequest(Endpoint.GAME_MODES, QueryBuilder.build())
    return GameModeResult.parseFrom(bytes).gamemodesList
}

@Throws(RequestException::class)
fun IGDBApi.gameVersion(QueryBuilder: QueryBuilder): List<GameVersion> {
    val bytes = protoRequest(Endpoint.GAME_VERSIONS, QueryBuilder.build())
    return GameVersionResult.parseFrom(bytes).gameversionsList
}

@Throws(RequestException::class)
fun IGDBApi.gameVersionFeatures(QueryBuilder: QueryBuilder): List<GameVersionFeature> {
    val bytes = protoRequest(Endpoint.GAME_VERSION_FEATURES, QueryBuilder.build())
    return GameVersionFeatureResult.parseFrom(bytes).gameversionfeaturesList
}

@Throws(RequestException::class)
fun IGDBApi.gameVersionFeatureValues(QueryBuilder: QueryBuilder): List<GameVersionFeatureValue> {
    val bytes = protoRequest(Endpoint.GAME_VERSION_FEATURE_VALUES, QueryBuilder.build())
    return GameVersionFeatureValueResult.parseFrom(bytes).gameversionfeaturevaluesList
}

@Throws(RequestException::class)
fun IGDBApi.gameVideos(QueryBuilder: QueryBuilder): List<GameVideo> {
    val bytes = protoRequest(Endpoint.GAME_VIDEOS, QueryBuilder.build())
    return GameVideoResult.parseFrom(bytes).gamevideosList
}

@Throws(RequestException::class)
fun IGDBApi.genres(QueryBuilder: QueryBuilder): List<Genre> {
    val bytes = protoRequest(Endpoint.GENRES, QueryBuilder.build())
    return GenreResult.parseFrom(bytes).genresList
}

@Throws(RequestException::class)
fun IGDBApi.involvedCompanies(QueryBuilder: QueryBuilder): List<InvolvedCompany> {
    val bytes = protoRequest(Endpoint.INVOLVED_COMPANIES, QueryBuilder.build())
    return InvolvedCompanyResult.parseFrom(bytes).involvedcompaniesList
}

@Throws(RequestException::class)
fun IGDBApi.keywords(QueryBuilder: QueryBuilder): List<Keyword> {
    val bytes = protoRequest(Endpoint.KEYWORDS, QueryBuilder.build())
    return KeywordResult.parseFrom(bytes).keywordsList
}

@Throws(RequestException::class)
fun IGDBApi.languages(QueryBuilder: QueryBuilder): List<Language> {
    val bytes = protoRequest(Endpoint.LANGUAGES, QueryBuilder.build())
    return LanguageResult.parseFrom(bytes).languagesList
}

@Throws(RequestException::class)
fun IGDBApi.languageSupports(QueryBuilder: QueryBuilder): List<LanguageSupport> {
    val bytes = protoRequest(Endpoint.LANGUAGE_SUPPORTS, QueryBuilder.build())
    return LanguageSupportResult.parseFrom(bytes).languagesupportsList
}

@Throws(RequestException::class)
fun IGDBApi.languageSupportTypes(QueryBuilder: QueryBuilder): List<LanguageSupportType> {
    val bytes = protoRequest(Endpoint.LANGUAGE_SUPPORT_TYPES, QueryBuilder.build())
    return LanguageSupportTypeResult.parseFrom(bytes).languagesupporttypesList
}

@Throws(RequestException::class)
fun IGDBApi.multiplayerModes(QueryBuilder: QueryBuilder): List<MultiplayerMode> {
    val bytes = protoRequest(Endpoint.MULTIPLAYER_MODES, QueryBuilder.build())
    return MultiplayerModeResult.parseFrom(bytes).multiplayermodesList
}

@Throws(RequestException::class)
fun IGDBApi.platforms(QueryBuilder: QueryBuilder): List<Platform> {
    val bytes = protoRequest(Endpoint.PLATFORMS, QueryBuilder.build())
    return PlatformResult.parseFrom(bytes).platformsList
}

@Throws(RequestException::class)
fun IGDBApi.platformLogos(QueryBuilder: QueryBuilder): List<PlatformLogo> {
    val bytes = protoRequest(Endpoint.PLATFORM_LOGOS, QueryBuilder.build())
    return PlatformLogoResult.parseFrom(bytes).platformlogosList
}

@Throws(RequestException::class)
fun IGDBApi.platformVersions(QueryBuilder: QueryBuilder): List<PlatformVersion> {
    val bytes = protoRequest(Endpoint.PLATFORM_VERSIONS, QueryBuilder.build())
    return PlatformVersionResult.parseFrom(bytes).platformversionsList
}

@Throws(RequestException::class)
fun IGDBApi.platformVersionCompanies(QueryBuilder: QueryBuilder): List<PlatformVersionCompany> {
    val bytes = protoRequest(Endpoint.PLATFORM_VERSION_COMPANIES, QueryBuilder.build())
    return PlatformVersionCompanyResult.parseFrom(bytes).platformversioncompaniesList
}

@Throws(RequestException::class)
fun IGDBApi.platformVersionReleaseDates(QueryBuilder: QueryBuilder): List<PlatformVersionReleaseDate> {
    val bytes = protoRequest(Endpoint.PLATFORM_VERSION_RELEASE_DATES, QueryBuilder.build())
    return PlatformVersionReleaseDateResult.parseFrom(bytes).platformversionreleasedatesList
}

@Throws(RequestException::class)
fun IGDBApi.platformWebsites(QueryBuilder: QueryBuilder): List<PlatformWebsite> {
    val bytes = protoRequest(Endpoint.PLATFORM_WEBSITES, QueryBuilder.build())
    return PlatformWebsiteResult.parseFrom(bytes).platformwebsitesList
}

@Throws(RequestException::class)
fun IGDBApi.playerPerspectives(QueryBuilder: QueryBuilder): List<PlayerPerspective> {
    val bytes = protoRequest(Endpoint.PLAYER_PERSPECTIVES, QueryBuilder.build())
    return PlayerPerspectiveResult.parseFrom(bytes).playerperspectivesList
}

@Throws(RequestException::class)
fun IGDBApi.platformFamilies(QueryBuilder: QueryBuilder): List<PlatformFamily> {
    val bytes = protoRequest(Endpoint.PLATFORM_FAMILIES, QueryBuilder.build())
    return PlatformFamilyResult.parseFrom(bytes).platformfamiliesList
}

@Throws(RequestException::class)
fun IGDBApi.regions(QueryBuilder: QueryBuilder): List<Region> {
    val bytes = protoRequest(Endpoint.REGIONS, QueryBuilder.build())
    return RegionResult.parseFrom(bytes).regionsList
}

@Throws(RequestException::class)
fun IGDBApi.releaseDates(QueryBuilder: QueryBuilder): List<ReleaseDate> {
    val bytes = protoRequest(Endpoint.RELEASE_DATES, QueryBuilder.build())
    return ReleaseDateResult.parseFrom(bytes).releasedatesList
}

@Throws(RequestException::class)
fun IGDBApi.screenshots(QueryBuilder: QueryBuilder): List<Screenshot> {
    val bytes = protoRequest(Endpoint.SCREENSHOTS, QueryBuilder.build())
    return ScreenshotResult.parseFrom(bytes).screenshotsList
}

@Throws(RequestException::class)
fun IGDBApi.search(QueryBuilder: QueryBuilder): List<Search> {
    val bytes = protoRequest(Endpoint.SEARCH, QueryBuilder.build())
    return SearchResult.parseFrom(bytes).searchesList
}

@Throws(RequestException::class)
fun IGDBApi.themes(QueryBuilder: QueryBuilder): List<Theme> {
    val bytes = protoRequest(Endpoint.THEMES, QueryBuilder.build())
    return ThemeResult.parseFrom(bytes).themesList
}

@Throws(RequestException::class)
fun IGDBApi.websites(QueryBuilder: QueryBuilder): List<Website> {
    val bytes = protoRequest(Endpoint.WEBSITES, QueryBuilder.build())
    return WebsiteResult.parseFrom(bytes).websitesList
}

@Throws(RequestException::class)
fun IGDBApi.events(QueryBuilder: QueryBuilder): List<Event> {
    val bytes = protoRequest(Endpoint.EVENTS, QueryBuilder.build())
    return EventResult.parseFrom(bytes).eventsList
}

@Throws(RequestException::class)
fun IGDBApi.eventLogos(QueryBuilder: QueryBuilder): List<EventLogo> {
    val bytes = protoRequest(Endpoint.EVENT_LOGOS, QueryBuilder.build())
    return EventLogoResult.parseFrom(bytes).eventlogosList
}


@Throws(RequestException::class)
fun IGDBApi.eventNetworks(QueryBuilder: QueryBuilder): List<EventNetwork> {
    val bytes = protoRequest(Endpoint.EVENT_NETWORKS, QueryBuilder.build())
    return EventNetworkResult.parseFrom(bytes).eventnetworksList
}

@Throws(RequestException::class)
fun IGDBApi.networkTypes(QueryBuilder: QueryBuilder): List<NetworkType> {
    val bytes = protoRequest(Endpoint.NETWORK_TYPES, QueryBuilder.build())
    return NetworkTypeResult.parseFrom(bytes).networktypesList
}

@Throws(RequestException::class)
fun IGDBApi.collectionRelations(QueryBuilder: QueryBuilder): List<CollectionRelation> {
    val bytes = protoRequest(Endpoint.COLLECTION_RELATIONS, QueryBuilder.build())
    return CollectionRelationResult.parseFrom(bytes).collectionrelationsList
}

@Throws(RequestException::class)
fun IGDBApi.collectionRelationTypes(QueryBuilder: QueryBuilder): List<CollectionRelationType> {
    val bytes = protoRequest(Endpoint.COLLECTION_RELATION_TYPES, QueryBuilder.build())
    return CollectionRelationTypeResult.parseFrom(bytes).collectionrelationtypesList
}

@Throws(RequestException::class)
fun IGDBApi.collectionTypes(QueryBuilder: QueryBuilder): List<CollectionType> {
    val bytes = protoRequest(Endpoint.COLLECTION_TYPES, QueryBuilder.build())
    return CollectionTypeResult.parseFrom(bytes).collectiontypesList
}

@Throws(RequestException::class)
fun IGDBApi.collectionMemberships(QueryBuilder: QueryBuilder): List<CollectionMembership> {
    val bytes = protoRequest(Endpoint.COLLECTION_MEMBERSHIPS, QueryBuilder.build())
    return CollectionMembershipResult.parseFrom(bytes).collectionmembershipsList
}

@Throws(RequestException::class)
fun IGDBApi.collectionMembershipTypes(QueryBuilder: QueryBuilder): List<CollectionMembershipType> {
    val bytes = protoRequest(Endpoint.COLLECTION_MEMBERSHIP_TYPES, QueryBuilder.build())
    return CollectionMembershipTypeResult.parseFrom(bytes).collectionmembershiptypesList
}

@Throws(RequestException::class)
fun IGDBApi.popularityTypes(QueryBuilder: QueryBuilder): List<PopularityType> {
    val bytes = protoRequest(Endpoint.POPULARITY_TYPES, QueryBuilder.build())
    return PopularityTypeResult.parseFrom(bytes).popularitytypesList
}

@Throws(RequestException::class)
fun IGDBApi.popularityPrimitives(QueryBuilder: QueryBuilder): List<PopularityPrimitive> {
    val bytes = protoRequest(Endpoint.COLLECTION_MEMBERSHIP_TYPES, QueryBuilder.build())
    return PopularityPrimitiveResult.parseFrom(bytes).popularityprimitivesList
}